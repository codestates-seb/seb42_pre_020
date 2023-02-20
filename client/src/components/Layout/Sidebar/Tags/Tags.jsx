import Tag from '../../../UI/Tag/Tag';

import styles from './Tags.module.css';

function Tags({ tags }) {
  return (
    <ul className={styles.tags}>
      {tags.map((tag) => (
        <li key={tag.text} className={styles.tag}>
          <Tag {...tag} />
        </li>
      ))}
    </ul>
  );
}

export default Tags;
