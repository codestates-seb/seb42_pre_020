import { useState } from 'react';

import Button from '../../UI/Button/Button';
import LabelInput from '../../UI/LabelInput/LabelInput';

import styles from './LoginForm.module.css';

function LoginForm() {
  const emailProps = {
    id: 'email',
    label: 'Email',
    inputProps: {
      size: 'large',
      type: 'email',
    },
  };
  const passwordProps = {
    id: 'password',
    label: 'Password',
    linkProps: {
      to: '/',
      text: 'Forgot password?',
    },
    inputProps: {
      size: 'large',
      type: 'password',
    },
  };

  const [isValidEmail, setIsValidEmail] = useState(true);
  const [isValidPassword, setIsValidPassword] = useState(true);

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const onChangeEmailHandler = (e) => {
    setEmail(e.target.value);
  };
  const onChangePasswordHandler = (e) => {
    setPassword(e.target.value);
  };

  const onSubmitHandler = (e) => {
    console.log('로그인');
    e.preventDefault();
  };

  return (
    <form className={styles.form} onSubmit={onSubmitHandler}>
      <LabelInput
        isValid={isValidEmail}
        value={email}
        onChange={onChangeEmailHandler}
        {...emailProps}
      />
      <LabelInput
        isValid={isValidPassword}
        value={password}
        onChange={onChangePasswordHandler}
        {...passwordProps}
      />
      <Button text="Log in" block />
    </form>
  );
}

export default LoginForm;
