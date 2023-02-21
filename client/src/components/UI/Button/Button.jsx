import { Link } from 'react-router-dom';

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
      <Link
        className={`${styles.button} ${styles[color]} 
      ${styles[size]} ${disabled ? `${styles.disabled}` : ``}`}
        to={url}
        {...props}
      >
        {text}
      </Link>
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
