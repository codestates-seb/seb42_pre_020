import { useState, useEffect } from 'react';

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
  const [image, setImage] = useState({
    image_file: '',
    preview_URL: isDefault(profileimage),
  });
  let inputRef;

  function isDefault(imgURL) {
    return imgURL.length === 0 ? default_img : profileimage;
  }

  const saveImage = (e) => {
    e.preventDefault();
    if (e.target.files[0]) {
      // 새로운 이미지를 올리면 createObjectURL()을 통해 생성한 기존 URL을 폐기
      URL.revokeObjectURL(image.preview_URL);
      const preview_URL = URL.createObjectURL(e.target.files[0]);
      setImage(() => ({
        image_file: e.target.files[0],
        preview_URL: preview_URL,
      }));
    }
  };

  const deleteImage = () => {
    // createObjectURL()을 통해 생성한 기존 URL을 폐기
    URL.revokeObjectURL(image.preview_URL);
    setImage({
      image_file: '',
      preview_URL: default_img,
    });
  };

  useEffect(() => {
    // 컴포넌트가 언마운트되면 createObjectURL()을 통해 생성한 기존 URL을 폐기
    return () => {
      URL.revokeObjectURL(image.preview_URL);
    };
  }, []);

  return (
    <div
      className={styles.Edit_image}
      onClick={(e) => e.stopPropagation()}
      role="presentation"
    >
      <img
        className={styles.user_image}
        src={image.preview_URL}
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
              src={image.preview_URL}
              alt="Preview"
            />
            <div className={styles.orange_button}>
              <Button
                text="Remove"
                size="large"
                color="orange"
                disabled={image.preview_URL === default_img ? true : false}
                onClick={deleteImage}
              />
            </div>
          </div>
          <label className={styles.input_file_button} htmlFor="input-file">
            Upload a new image
          </label>
          <input
            type="file"
            id="input-file"
            onChange={saveImage}
            onClick={(e) => (e.target.value = null)}
            ref={(refParam) => (inputRef = refParam)}
            accept=".jpg, .jpeg, .png"
            style={{ display: 'none' }}
          />
          <Button
            text="Confirm"
            size="small"
            color="border"
            block
            onClick={openModalHandler}
          />
        </div>
      ) : null}
    </div>
  );
}

export default EditPic;
