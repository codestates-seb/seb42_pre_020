import { RiKakaoTalkFill } from 'react-icons/ri';
import { FcGoogle } from 'react-icons/fc';
import { BsGithub } from 'react-icons/bs';

import styles from './SocialButton.module.css';

function SocialButton({ type = 'kakao', onClick }) {
  const icons = {
    kakao: {
      icon: <RiKakaoTalkFill />,
      inversion: false,
    },
    google: {
      icon: <FcGoogle />,
      inversion: false,
    },
    gitHub: {
      icon: <BsGithub />,
      inversion: true,
    },
  };

  return (
    <button
      className={`
      ${styles.button} 
      ${icons[type].inversion ? `${styles.inversion}` : ''} 
      ${styles[type]}`}
      onClick={onClick}
    >
      <div className={`${styles.icon} `}>{icons[type].icon}</div>
      Log in with&nbsp;<span className={styles.type}>{type}</span>
    </button>
  );
}

export default SocialButton;
