import styles from './ListItem.module.css';

function ListItemA() {
  return (
    <div className={styles.Item_container}>
      <a
        className={styles.A_detail}
        href="https://www.google.com"
      >{`사자던 호랑이던 내가 다이김! 암튼 그럼 ㅇㅇ`}</a>
      <div className={styles.A_info}>
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

export default ListItemA;
