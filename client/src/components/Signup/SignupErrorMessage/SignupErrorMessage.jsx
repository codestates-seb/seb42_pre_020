import styles from './SignupErrorMessage.module.css';

const ERROR_CODE = {
  empty: 'cannot be empty.',
  invalid: 'was invalid.',
};

function SignupErrorMessage({ name, status, error }) {
  if (!error) return <></>;

  return (
    <span className={styles.error}>
      {name}&nbsp;
      {ERROR_CODE[status]}
    </span>
  );
}

export default SignupErrorMessage;
