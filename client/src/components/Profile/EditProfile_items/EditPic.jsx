import { useState } from 'react';

import default_img from '../../../assets/images/default.png';
import Button from '../../UI/Button/Button';

import styles from './EditPic.module.css';

function EditPic({
  openModalHandler,
  isOpen,
  profileimage,
  userData,
  setUserData,
}) {
  const [preview, setPreview] = useState();
  function isDefault(imgURL) {
    return imgURL.length === 0 ? default_img : profileimage;
  }
  return (
    <div
      className={styles.Edit_image}
      onClick={(e) => e.stopPropagation()}
      role="presentation"
    >
      <img
        className={styles.user_image}
        src={isDefault(profileimage)}
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
              src={profileimage}
              alt="Preview"
            />
            <div className={styles.orange_button}>
              <Button text="remove" size="large" color="orange" disabled />
            </div>
          </div>
          <Button text="Upload a new image" size="small" block />
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
