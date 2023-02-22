import SocialButton from '../UI/SocialButton/SocialButton';
import SignupForm from './SignupForm/SignupForm';
import MessageLink from '../UI/MessageLink/MessageLink';

import styles from './Signup.module.css';

function Signup() {
  const onSocialSignUpHandler = (type) => {
    console.log('type', type);
  };

  return (
    <div className={styles.signup_container}>
      {/* 소셜 버튼 */}
      <div className={styles.social_buttons}>
        <SocialButton
          type="google"
          onClick={onSocialSignUpHandler.bind(null, 'google')}
        />
        <SocialButton
          type="gitHub"
          onClick={onSocialSignUpHandler.bind(null, 'gitHub')}
        />
        <SocialButton
          type="kakao"
          onClick={onSocialSignUpHandler.bind(null, 'kakao')}
        />
      </div>

      {/* 회원가입 폼 */}
      <SignupForm />

      {/* 메시지 링크 */}
      <div>
        <MessageLink
          to="/login"
          text="Already have an account?"
          linkText="Log in"
        />
        <MessageLink
          to="/"
          text="Are you an employer?"
          linkText="Sign up on Talent"
        />
      </div>
    </div>
  );
}

export default Signup;
