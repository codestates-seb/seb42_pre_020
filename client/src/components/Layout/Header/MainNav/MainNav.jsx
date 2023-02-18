import Button from '../../../UI/Button/Button';

import styles from './MainNav.module.css';

function MainNav({ isLogin }) {
  if (isLogin) {
    return (
      <>
        <li>
          <a href="/" className={styles.proflie}>
            <img
              className={styles.profile_img}
              // 임시 이미지 URL
              src={
                'https://lh3.googleusercontent.com/a/AEdFTp6IU-GXqHrorT7WFa-SaIxCn9t0_qhbxi85HOTi3g=k-s48'
              }
              alt="profile"
            />
          </a>
        </li>
        <li>
          <Button color="red" text="Log Out" size="small" />
        </li>
      </>
    );
  }

  return (
    <>
      <li>
        <Button text="Log In" size="small" color="border" url="/" />
      </li>
      <li>
        <Button text="Sign up" size="small" url="/" />
      </li>
    </>
  );
}

export default MainNav;
