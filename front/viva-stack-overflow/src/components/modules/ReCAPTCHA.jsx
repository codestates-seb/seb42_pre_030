import ReCAPTCHA from "react-google-recaptcha";
const Captcha = () => {
  function onChange(value) {
    console.log('Captcha value:', value);
  }
  return (
    <div>
      <ReCAPTCHA
        sitekey="6LcPGKUkAAAAAK3XDn_pQn_MqZqQNCQX7S8BXoZ7"
        onChange={onChange}
        style={{width:"264.984px", height:"144px"}}
      />
    </div>
  );
};

export default Captcha;