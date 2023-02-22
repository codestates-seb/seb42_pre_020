import styles from './Input.module.css';

function Input({
  placeholder,
  size,
  value = '',
  onChange = () => {},
  onPressEnterKey = () => {},
  isValid,
  leftIcon,
  rightIcon,
  id,
  type = 'text',
}) {
  const keydownHandler = (e) => {
    if (e.key === 'Enter') {
      onPressEnterKey(value);
    }
  };
  return (
    <div className={styles.container}>
      {leftIcon && (
        <div className={`${styles.icon} ${styles.left}`}>{leftIcon}</div>
      )}
      <input
        className={`${styles.input} ${size ? `${styles[size]}` : ``} ${
          isValid ? `` : `${styles.error}`
        }`}
        type={type}
        placeholder={placeholder}
        onChange={onChange}
        onKeyDown={keydownHandler}
        value={value}
        id={id}
      />
      {rightIcon && (
        <div className={`${styles.icon} ${styles.right}`}>{rightIcon}</div>
      )}
    </div>
  );
}

export default Input;
