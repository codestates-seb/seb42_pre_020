import { Link } from 'react-router-dom';

import Input from '../Input/Input';

import styles from './LabelInput.module.css';

function LabelInput({
  inputProps,
  id,
  label = '',
  linkProps,
  isValid,
  value,
  onChange,
  description,
}) {
  return (
    <div className={styles.container}>
      <div className={styles.label_container}>
        <label htmlFor={id} className={styles.label}>
          {label}
        </label>
        {linkProps && (
          <Link className={styles.link} {...linkProps}>
            {linkProps.text}
          </Link>
        )}
      </div>
      <Input
        id={id}
        value={value}
        onChange={onChange}
        isValid={isValid}
        {...inputProps}
      />
      {description && <div className={styles.description}>{description}</div>}
    </div>
  );
}

export default LabelInput;
