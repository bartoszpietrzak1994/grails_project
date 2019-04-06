package recaptcha

import org.springframework.web.client.RestTemplate

class ReCaptchaChecker
{
    private String secret

    private static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify"

    boolean verifyResponse(String response)
    {
        RestTemplate restTemplate = new RestTemplate()

        CaptchaRequest captchaRequest = new CaptchaRequest(secret, response, "", GOOGLE_RECAPTCHA_VERIFY_URL)
        CaptchaResponse captchaResponse = restTemplate.getForObject(captchaRequest.getVerifyURI(), CaptchaResponse.class)

        assert captchaResponse != null
        return Optional.ofNullable(captchaResponse.isSuccess()).orElse(false)
    }

    void setSecret(String secret)
    {
        this.secret = secret
    }
}
