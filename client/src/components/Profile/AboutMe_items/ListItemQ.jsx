import Tag from '../../UI/Tag/Tag';
import styles from './ListItem.module.css';

function ListItemQ() {
  return (
    <div className={styles.Item_container}>
      <a
        className={styles.Q_title}
        href="https://www.google.com"
      >{`호랑이랑 사자랑 싸우면 누가 이기나요?`}</a>
      <div className={styles.Q_info}>
        <div className={styles.tag_list}>
          <Tag url="" text="동물" />
          <Tag url="" text="맹수" />
          <Tag url="" text="싸움순위" />
          <Tag url="" text="호랑이" />
          <Tag url="" text="사자" />
        </div>
        <div className={styles.user_info}>
          <span>
            <img
              className={styles.user_image}
              src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Noto_Emoji_Oreo_1f914.svg/1200px-Noto_Emoji_Oreo_1f914.svg.png"
              alt="My profile"
            />
          </span>
          <span className={styles.user_name}>{`One-Punch Man`}</span>
          <span className={styles.date}>{`2019-08-25 12:36:09`}</span>
        </div>
      </div>
    </div>
  );
}

export default ListItemQ;
