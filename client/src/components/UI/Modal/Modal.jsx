import { createPortal } from 'react-dom';

import Button from '../Button/Button';

import styles from './Modal.module.css';

function Modal({ onClose, onClick, title, children, buttonText }) {
  return createPortal(
    <div className={styles.modal_container}>
      <div className={styles.modal}>
        <h2 className={styles.title}>{title}</h2>
        <div className={styles.body}>{children}</div>
        <div className={styles.buttons}>
          <div className={styles.button}>
            <Button onClick={onClick} color="red" text={buttonText} />
          </div>
          <div className={styles.button}>
            <Button onClick={onClose} color="transparent" text="Cancel" />
          </div>
        </div>
      </div>
    </div>,
    document.getElementById('root')
  );
}

export default Modal;
