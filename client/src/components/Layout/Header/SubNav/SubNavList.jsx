import styles from './SubNavList.module.css';

function SubNavList({ text, url }) {
  return (
    <ul className={styles.sub_nav}>
      <li className={styles.list}>
        <a href={url} className={styles.link}>
          {text}
        </a>
      </li>
    </ul>
  );
}

export default SubNavList;
