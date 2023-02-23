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
            src="https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
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
