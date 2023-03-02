import Tag from '../../UI/Tag/Tag';

import styles from './ListItem.module.css';

// 임의의 데이터
const users = {
  name: `One-Punch Man`,
  profileimage:
    'https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80',
};
//

function ListItemQ({ questions, setQuestions }) {
  const { title, tags, create_dt } = questions;

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
      <a className={styles.Q_title} href="/">
        {questions[0].title}
      </a>
      <div className={styles.Q_info}>
        <div className={styles.tag_list}>
          {questions[0].tags.map((tag) => (
            <Tag key={tag} url="" text={tag} />
          ))}
        </div>
        <div className={styles.user_info}>
          <span>
            <img
              className={styles.user_image}
              src={users.profileimage}
              alt="My profile"
            />
          </span>
          <span className={styles.user_name}>{users.name}</span>
          <span className={styles.date}>
            {dateFormat(questions[0].create_dt)}
          </span>
        </div>
      </div>
    </div>
  );
}

export default ListItemQ;
