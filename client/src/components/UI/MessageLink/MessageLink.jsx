import { Link } from 'react-router-dom';

import styles from './MessageLink.module.css';

function MessageLink({ text, linkText, to }) {
  return (
    <div className={styles.text}>
      {text}
      <Link className={styles.link} to={to}>
        &nbsp;{linkText}
      </Link>
    </div>
  );
}

export default MessageLink;
