import { useState } from 'react';

import Button from '../../UI/Button/Button';

import styles from './EditPic.module.css';

function EditPic({ openModalHandler, isOpen }) {
  return (
    <div
      className={styles.Edit_image}
      onClick={(e) => e.stopPropagation()}
      role="presentation"
    >
      <img
        className={styles.user_image}
        src="https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
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
              src="https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
              alt="Preview"
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
