import { useState } from 'react';

import Button from '../../UI/Button/Button';

import styles from './EditPic.module.css';

function EditPic({ openModalHandler, isOpen }) {
  return (
    <div
      className={styles.Edit_Pic}
      onClick={(e) => e.stopPropagation()}
      role="presentation"
    >
      <img
        className={styles.user_image}
        src="https://cdn-icons-png.flaticon.com/512/9655/9655066.png"
        alt="Current"
      />
      <button className={styles.ChangePic_Btn} onClick={openModalHandler}>
        Change picture
      </button>
      {isOpen ? (
        <div className={styles.Modal}>
          <div className={styles.container}>
            <img
              className={styles.preview_image}
              src="https://cdn-icons-png.flaticon.com/512/9655/9655066.png"
              alt="Default"
            />
            <div className={styles.orange_button}>
              <Button text="remove" size="large" color="orange" disabled />
            </div>
          </div>
          <Button text="Uplooad a new image" size="small" block />
          <div className={styles.last_container}>
            <Button
              text="Cancel"
              size="small"
              color="border"
              block
              onClick={openModalHandler}
            />
          </div>
        </div>
      ) : null}
    </div>
  );
}

export default EditPic;
