package com.example.demo.controller;

import com.example.demo.dto.HelloData;
import com.example.demo.dto.TestObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @RequestMapping에 method 속성으로 HTTP 메서드를 지정하지 않으면
 * GET, HEAD, POST, PUT, PATCH, DELETE 모두 허용
 *
 */

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

    // http://localhost:8080/request-param-v3?username=hello&age=20
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

    // http://localhost:8080/model-attribute-v1?username=hello&age=20
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

    /*** RequestBodyStringController ***/
    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        responseWriter.write("ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        log.info("messageBody={}", httpEntity.getBody());

        return new HttpEntity<>("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {
        log.info("messageBody={}", messageBody);

        return "ok";
    }
    /****************************************/

    /*** RequestBodyJsonController ***/
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }

    /**
     * @RequestBody
     * HttpMessageConverter 사용 -> StringHttpMessageConverter 적용
     *
     * @ResponseBody
     * - 모든 메서드에 @ResponseBody 적용
     * - 메시지 바디 정보 직접 반환(view 조회X)
     * - HttpMessageConverter 사용 -> StringHttpMessageConverter 적용
     */
    @ResponseBody
    @PostMapping("request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {
        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    /**
     * @RequestBody 생략 불가능(@ModelAttribute 가 적용되어 버림)
     * HttpMessageConverter 사용 -> MappingJackson2HttpMessageConverter (contenttype: application/json)
     */
    @ResponseBody
    @PostMapping("request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData) throws IOException { //!
        log.info("messageBody={}", helloData);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> httpEntity) throws IOException {
        HelloData data = httpEntity.getBody();
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "ok";
    }

    /**
     * @RequestBody 생략 불가능(@ModelAttribute 가 적용되어 버림)
     * HttpMessageConverter 사용 -> MappingJackson2HttpMessageConverter (contenttype: application/json)
     *
     * @ResponseBody 적용
     * - 메시지 바디 정보 직접 반환(view 조회X)
     * - HttpMessageConverter 사용 -> MappingJackson2HttpMessageConverter 적용
    (Accept: application/json)
     */
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData data) { //!
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return data;
    }

    @ResponseBody
    @PostMapping("request-body-json-v6")
    public TestObject requestBodyJsonV6(@RequestBody HelloData helloData) throws IOException { //!
        log.info("messageBody={}", helloData);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        TestObject testObject = new TestObject();

        if (helloData.getUsername().equals("kim")) {
            testObject.setText("seoul");
        } else {
            testObject.setText("busan");
        }

        if (helloData.getAge() == 10) {
            testObject.setNumber(33);
        } else {
            testObject.setNumber(44);
        }

        return testObject;
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
        return "response/hello";
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
