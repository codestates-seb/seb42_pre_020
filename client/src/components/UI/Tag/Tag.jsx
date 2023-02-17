import styles from './Tag.module.css';

function Tag({ url = '', text }) {
  return (
    <a className={styles.tag} href={url}>
      {text}
    </a>
  );
}

export default Tag;
