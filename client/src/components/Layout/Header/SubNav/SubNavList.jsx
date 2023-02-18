import styles from './SubNavList.module.css';

function SubNavList({ text, url }) {
  return (
    <li className={styles.list}>
      <a href={url} className={styles.link}>
        {text}
      </a>
    </li>
  );
}

export default SubNavList;
