import { Link } from 'react-router-dom';

import styles from './Tag.module.css';

function Tag({ url = '', text }) {
  return (
    <Link className={styles.tag} title={text} to={`${text}`}>
      {text}
    </Link>
  );
}

export default Tag;
