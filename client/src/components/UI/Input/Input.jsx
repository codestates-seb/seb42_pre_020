import { BiSearch } from 'react-icons/bi';
import styles from './Input.module.css';

function Input({
  placeholder,
  size,
  value = '',
  onChange = () => {},
  onSubmit = () => {},
}) {
  const onSubmitHandler = (e) => {
    e.preventDefault();
    onSubmit();
  };

  return (
    <form className={styles.container} onSubmit={onSubmitHandler}>
      <div className={styles.icon}>
        <BiSearch size="1.5rem" />
      </div>
      <input
        className={`${styles.input} ${size ? `${styles[size]}` : ``}`}
        type={'text'}
        placeholder={placeholder}
        onChange={onChange}
        value={value}
      />
    </form>
  );
}

export default Input;
