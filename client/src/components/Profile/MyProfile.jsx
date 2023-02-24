import default_img from '../../assets/images/default.png';
import { MdCake } from 'react-icons/md';
import {
  RiPencilFill,
  RiQuestionnaireFill,
  RiMessage2Fill,
} from 'react-icons/ri';

import styles from './MyProfile.module.css';

// 임의의 데이터
const users = {
  name: `One-Punch Man`,
  profileimage:
    'https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80',
  create_dt: 'Thu Oct 02 2022 12:50:02 GMT+0900 (한국 표준시)',
};
const question = {
  create_dt: 'Thu Jan 10 2023 17:23:21 GMT+0900 (한국 표준시)',
};
const answer = {
  create_dt: 'Thu Feb 23 2023 22:02:35 GMT+0900 (한국 표준시)',
};
//

function MyProfile() {
  function elapsedTime(date) {
    const start = new Date(date);
    const end = new Date();
    const diff = (end - start) / 1000;
    const times = [
      { name: 'year', milliSeconds: 60 * 60 * 24 * 365 },
      { name: 'month', milliSeconds: 60 * 60 * 24 * 30 },
      { name: 'day', milliSeconds: 60 * 60 * 24 },
      { name: 'hour', milliSeconds: 60 * 60 },
      { name: 'min', milliSeconds: 60 },
    ];

    for (const value of times) {
      const betweenTime = Math.floor(diff / value.milliSeconds);

      if (betweenTime === 1) {
        return `${betweenTime} ${value.name}`;
      } else if (betweenTime > 0) {
        return `${betweenTime} ${value.name}s`;
      }
    }
    return '0 min';
  }

  return (
    <div className={styles.MyProfile_Container}>
      <div className={styles.MyProfile_image}>
        <a href="/mypage">
          <img
            className={styles.user_image}
            src={default_img}
            alt="My profile"
          />
        </a>
      </div>
      <div className={styles.MyProfile_info}>
        <h2 className={styles.user_name}>{users.name}</h2>
        <div className={styles.user_history}>
          <span>
            <MdCake className={styles.cake_icon} />
            {`Member for ${elapsedTime(users.create_dt)}`}
          </span>
          <span>
            <RiQuestionnaireFill className={styles.msg_icon} />
            {`Last question ${elapsedTime(question.create_dt)} ago`}
          </span>
          <span>
            <RiMessage2Fill className={styles.msg_icon} />
            {`Last answer ${elapsedTime(answer.create_dt)} ago`}
          </span>
        </div>
      </div>
      <a className={styles.Button} href="/editprofile">
        <RiPencilFill className={styles.button_icon} />
        <span className={styles.button_text}>Edit profile</span>
      </a>
    </div>
  );
}

export default MyProfile;
