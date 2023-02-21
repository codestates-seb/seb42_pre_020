// import { useState } from 'react'
import styles from './MyProfile.module.css';
import { MdCake } from 'react-icons/md';
import { AiOutlineClockCircle } from 'react-icons/ai';
import { RiPencilFill } from 'react-icons/ri';

function MyProfile() {
  return (
    <div className={styles.MyProfile_Container}>
      <div className={styles.MyProfile_image}>
        <a href="https://www.google.com">
          <img
            className={styles.user_image}
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Noto_Emoji_Oreo_1f914.svg/1200px-Noto_Emoji_Oreo_1f914.svg.png"
            alt="My profile"
          />
        </a>
      </div>
      <div className={styles.MyProfile_info}>
        <h2 className={styles.user_name}>{`One-Punch Man`}</h2>
        <div className={styles.user_history}>
          <span>
            <MdCake className={styles.cake_icon} />
            Member for 3 days
          </span>
          <span>
            <AiOutlineClockCircle className={styles.clock_icon} />
            Last seen this week
          </span>
        </div>
      </div>
      <a className={styles.Button} href="https://www.google.com">
        <RiPencilFill className={styles.button_icon} />
        <span className={styles.button_text}>Edit profile</span>
      </a>
    </div>
  );
}

export default MyProfile;
