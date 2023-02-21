import styles from './Button.module.css';


function Button({
  color = 'blue',
  text = '',
  size = 'normal',
  url,
  block,
  disabled,
  onClick = () => {},
  ...props
}) {
  // A tag
  if (url) {
    return (
      <a
        className={`${styles.button} ${styles[color]} 
      ${styles[size]} ${disabled ? `${styles.disabled}` : ``}`}
        href={url}
        {...props}
      >
        {text}
      </a>
    );
  }

  // Button tag
  return (
    <button
      onClick={onClick}
      className={`${styles.button} ${styles[color]} ${styles[size]}
      ${block ? `${styles.block}` : ``}`}
      disabled={!!disabled}
      {...props}
    >
      {text}
    </button>
  );
}

export default Button;
