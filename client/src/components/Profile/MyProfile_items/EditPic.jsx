import { useState } from 'react';
import styles from './EditPic.module.css';

function EditPic() {
  const [isOpen, setIsOpen] = useState(false);

  const openModalHandler = () => {
    console.log('Change picture');
    setIsOpen(!isOpen);
  };

  return (
    <div className={styles.Edit_Pic}>
      <img
        className={styles.user_image}
        src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Noto_Emoji_Oreo_1f914.svg/1200px-Noto_Emoji_Oreo_1f914.svg.png"
        alt="My profile"
      />
      <button className={styles.ChangePic_Btn} onClick={openModalHandler}>
        Change picture
      </button>
      {isOpen ? (
        <div
          className={styles.Modal_Backdrop}
          onClick={openModalHandler}
          role="presentation"
        >
          <div className={styles.Modal}></div>
        </div>
      ) : null}
    </div>
  );
}

export default EditPic;
