package com.example.demo.controller;

import com.example.demo.dto.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

//@RestController
@Controller
@Slf4j
public class SpringMvcController {

    @GetMapping("/springmvchtml")
    public String springMvcHtml() {
        log.debug("springmvc html");
        log.info("springmvc html");
        return "springmvc";
    }

    /*** RequestHeaderController ***/
    @RequestMapping("/headers")
    @ResponseBody
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false) String cookie) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok - log check";
    }
    /****************************************/

    /*** RequestParamController( query parameter(GET) or x-www-form-urlencoded(POST) ) ***/
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);
        response.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    @ResponseBody
    public String requestParamV2(@RequestParam("username") String username,
                                 @RequestParam("age") int age) {
        log.info("username={}, age={}", username, age);

        return "ok - " + username + ", " + age;
    }

    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3(@RequestParam String username, //! 제일 좋은 방법인듯
                                 @RequestParam int age) {
        log.info("username={}, age={}", username, age);

        return "ok - " + username + ", " + age;
    }

    @RequestMapping("/request-param-v4")
    @ResponseBody
    public String requestParamV4(String username, int age) { // 이런 스타일은 너무 과함
        log.info("username={}, age={}", username, age);

        return "ok - " + username + ", " + age;
    }

    @RequestMapping("/request-param-required")
    @ResponseBody
    public String requestParamRequired(@RequestParam String username,
                                       @RequestParam(required = false) Integer age) {
        //?username=hello&age= OR ?username=hello -> username=hello, age=null
        log.info("username={}, age={}", username, age);
        return "ok - " + username + ", " + age;
    }

    @RequestMapping("/request-param-default")
    @ResponseBody
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,
                                      @RequestParam(required = false, defaultValue = "-1") int age) {
        //?username=hello&age= OR ?username=hello -> username=hello, age=-1
        //?username=&age=20 OR ?age=20 -> username=guest, age=20
        log.info("username={}, age={}", username, age);
        return "ok - " + username + ", " + age;
    }

    @RequestMapping("/request-param-map")
    @ResponseBody
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok - " + paramMap.get("username") + ", " + paramMap.get("age");
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) { //!
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok - " + helloData.toString();
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok - " + helloData.toString();
    }
    /****************************************/

    /*** ResponseViewController ***/
    @GetMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello! responseViewV1");
        return mav;
    }

    @GetMapping("/response-view-v2")
    public String responseViewV2(Model model) { //!
        model.addAttribute("data", "hello!! responseViewV2");
        return "/response/hello";
    }

    // 비추 방법
    @GetMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
    /****************************************/

    /*** ResponseBodyController ***/
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException
    {
        response.getWriter().write("response-body-string-v1 ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("response-body-string-v2 ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "response-body-string-v3 ok";
    }


    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/response-body-json-v2")
    @ResponseBody
    public List<HelloData> responseBodyJsonV2() { //!
        List<HelloData> helloDataList = new ArrayList<>();

        HelloData helloData1 = new HelloData();
        helloData1.setUsername("hello1");
        helloData1.setAge(10);
        helloDataList.add(helloData1);

        HelloData helloData2 = new HelloData();
        helloData2.setUsername("hello2");
        helloData2.setAge(20);
        helloDataList.add(helloData2);

        for (HelloData data : helloDataList) {
            log.info("data={}", data);
        }

        return helloDataList;
    }
    /****************************************/

}
