// import { useState } from 'react'

import { MdCake } from 'react-icons/md';
import {
  RiPencilFill,
  RiQuestionnaireFill,
  RiMessage2Fill,
} from 'react-icons/ri';

import styles from './MyProfile.module.css';

function MyProfile() {
  return (
    <div className={styles.MyProfile_Container}>
      <div className={styles.MyProfile_image}>
        <a href="http://localhost:3000/mypage">
          <img
            className={styles.user_image}
            src="https://cdn-icons-png.flaticon.com/512/9655/9655066.png"
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
            <RiQuestionnaireFill className={styles.msg_icon} />
            Last question 2 days ago
          </span>
          <span>
            <RiMessage2Fill className={styles.msg_icon} />
            Last answer 1 hour ago
          </span>
        </div>
      </div>
      <a className={styles.Button} href="http://localhost:3000/editprofile">
        <RiPencilFill className={styles.button_icon} />
        <span className={styles.button_text}>Edit profile</span>
      </a>
    </div>
  );
}

export default MyProfile;
