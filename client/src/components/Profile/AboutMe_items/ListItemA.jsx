import styles from './ListItem.module.css';

// 임의의 데이터
const users = {
  name: `One-Punch Man`,
  profileimage:
    'https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80',
};
const answer = [
  {
    id: 111,
    q_id: 111111,
    detail: '사자던 호랑이던 내가 다이김! 암튼 그럼 ㅇㅇ',
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
];
//

function ListItemA() {
  function dateFormat(date) {
    const TIME_ZONE = 9 * 60 * 60 * 1000;
    const date_A = new Date(date);

    return new Date(date_A.getTime() + TIME_ZONE)
      .toISOString()
      .replace('T', ' ')
      .slice(0, -5);
  }

  return (
    <div className={styles.Item_container}>
      <a className={styles.A_detail} href="/">
        {answer[0].detail}
      </a>
      <div className={styles.A_info}>
        <div className={styles.user_info}>
          <span>
            <img
              className={styles.user_image}
              src={users.profileimage}
              alt="My profile"
            />
          </span>
          <span className={styles.user_name}>{users.name}</span>
          <span className={styles.date}>{dateFormat(answer[0].create_dt)}</span>
        </div>
      </div>
    </div>
  );
}

export default ListItemA;
