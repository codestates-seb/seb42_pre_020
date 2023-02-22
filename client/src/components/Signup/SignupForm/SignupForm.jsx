import { useState } from 'react';

import Button from '../../UI/Button/Button';
import LabelInput from '../../UI/LabelInput/LabelInput';
import SignupErrorMessage from '../SignupErrorMessage/SignupErrorMessage';

import styles from './SignupForm.module.css';

function SignupForm() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const onSubmitHandler = (e) => {
    e.preventDefault();
    console.log({
      name,
      email,
      password,
    });
  };

  const onChangeNameHandler = (e) => {
    setName(e.target.value);
  };
  const onChangeEmailHandler = (e) => {
    setEmail(e.target.value);
  };
  const onChangePasswordHandler = (e) => {
    setPassword(e.target.value);
  };

  const nameProps = {};
  const emailProps = {
    type: 'email',
  };
  const passwordProps = {
    type: 'password',
  };

  return (
    <form className={styles.form} onSubmit={onSubmitHandler}>
      <div className={styles.input}>
        <LabelInput
          label="Display name"
          inputProps={nameProps}
          value={name}
          onChange={onChangeNameHandler}
        />
        <SignupErrorMessage name="Display name" status="empty" error />
      </div>
      <div className={styles.input}>
        <LabelInput
          isValid
          label="Email"
          inputProps={emailProps}
          value={email}
          onChange={onChangeEmailHandler}
        />
        <SignupErrorMessage name="email" status="empty" />
      </div>
      <div className={styles.input}>
        <LabelInput
          isValid
          label="Password"
          inputProps={passwordProps}
          value={password}
          onChange={onChangePasswordHandler}
        />
        <SignupErrorMessage name="password" status="invalid" />
      </div>

      <Button text="Sign up" block />
      <div className={styles.terms}>
        By clicking “Sign up”, you agree to &nbsp;
        <a className={styles.link} href="/">
          &nbsp;our terms of service, privacy policy
        </a>
        &nbsp;and&nbsp;
        <a className={styles.link} href="/">
          cookie policy
        </a>
      </div>
    </form>
  );
}

export default SignupForm;
