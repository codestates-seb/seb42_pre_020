import { Link } from 'react-router-dom';

import styles from './SubNavList.module.css';

function SubNavList({ text, url }) {
  return (
    <ul className={styles.sub_nav}>
      <li className={styles.list}>
        <Link to={url} className={styles.link}>
          {text}
        </Link>
      </li>
    </ul>
  );
}

export default SubNavList;
