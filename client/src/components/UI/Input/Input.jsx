import styles from './Input.module.css';

function Input({
  placeholder,
  size,
  value = '',
  onChange = () => {},
  onSubmit = () => {},
  isValid,
  leftIcon,
  rightIcon,
}) {
  const onSubmitHandler = (e) => {
    e.preventDefault();
    onSubmit();
  };

  return (
    <form className={styles.container} onSubmit={onSubmitHandler}>
      {/* SEARCH */}
      {leftIcon && (
        <div className={`${styles.icon} ${styles.left}`}>{leftIcon}</div>
      )}
      <input
        className={`${styles.input} ${size ? `${styles[size]}` : ``} ${
          isValid ? `` : `${styles.error}`
        }`}
        type={'text'}
        placeholder={placeholder}
        onChange={onChange}
        value={value}
      />
      {rightIcon && (
        <div className={`${styles.icon} ${styles.right}`}>{rightIcon}</div>
      )}
    </form>
  );
}

export default Input;
