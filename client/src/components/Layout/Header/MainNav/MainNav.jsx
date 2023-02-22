import { Link } from 'react-router-dom';

import Button from '../../../UI/Button/Button';

import styles from './MainNav.module.css';

function MainNav({ isLogin }) {
  if (isLogin) {
    return (
      <ul className={`${styles.nav} ${styles.main_nav}`}>
        <li>
          <Link to="/mypage" className={styles.proflie}>
            <img
              className={styles.profile_img}
              // 임시 이미지 URL
              src={
                'https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80'
              }
              alt="profile"
            />
          </Link>
        </li>
        <li>
          <Button color="red" text="Log Out" size="small" url="/" />
        </li>
      </ul>
    );
  }

  return (
    <ul className={styles.main_nav}>
      <li>
        <Button text="Log In" size="small" color="border" url="/login" />
      </li>
      <li>
        <Button text="Sign up" size="small" url="/signup" />
      </li>
    </ul>
  );
}

export default MainNav;
