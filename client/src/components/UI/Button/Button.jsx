import styles from './Button.module.css';

function Button({
  type = 'blue',
  text = '',
  size = 'normal',
  url,
  block,
  onClick = () => {},
  ...props
}) {
  // A tag
  if (url) {
    return (
      <a
        {...props}
        className={`${styles.button} ${styles[type]} ${styles[size]}`}
        href={url}
      >
        {text}
      </a>
    );
  }

  // Button tag
  return (
    <button
      onClick={onClick}
      className={`${styles.button} ${styles[type]} ${styles[size]}
      ${block ? `${styles.block}` : ``}`}
      {...props}
    >
      {text}
    </button>
  );
}

export default Button;
