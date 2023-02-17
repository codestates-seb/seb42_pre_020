import styles from './Button.module.css';

function Button({ type = 'blue', text, size = 'normal', href }) {
  return (
    <button className={`${styles.button} ${styles[type]} ${styles[size]} `}>
      {text}
    </button>
  );
}

export default Button;
