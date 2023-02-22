import { useState } from 'react';

import Button from '../UI/Button/Button';
import styles from './Delete.module.css';

function Delete() {
  const [checked, setChecked] = useState(false);
  const checkHandler = () => {
    setChecked(!checked);
  };
  return (
    <div className={styles.Delete_Container}>
      <div className={styles.Delete_Head}>
        <h2 className={styles.Head_title}>Delete Profile</h2>
      </div>
      <div className={styles.Delete_Body}>
        <p className={styles.text}>
          프로필 삭제 의사를 확인하기 전에 잠시 시간을 내어 삭제의 의미를
          설명하겠습니다.
        </p>
        <ul className={styles.list}>
          <li className={styles.list_item}>
            삭제는 되돌릴 수 없으며 삭제를 수행하고 나중에 마음이 바뀌면 원래
            콘텐츠를 다시 얻을 수 있는 방법이 없습니다.
          </li>
          <li className={styles.list_item}>
            귀하의 질문과 답변은 사이트에 남아 있지만 연결이 해제되고 익명으로
            처리되며(저자는 `임의의 문자`로 표시됨)
            <br />
            나중에 사이트를 다시 방문하더라도 귀하의 저작권을 표시하지 않습니다.
          </li>
        </ul>
        <p className={styles.text}>
          삭제를 확인하면 해당 사이트의 프로필만 삭제되며 다른 사이트의 계정에는
          영향을 미치지 않습니다.
          <br />
          계속 삭제를 진행하려면 아래의 내용을 모두 확인한 뒤 체크박스를
          `체크`해주시길 바랍니다.
        </p>
        <label className={styles.label}>
          <input
            className={styles.checkbox}
            type="checkbox"
            checked={checked}
            onChange={(e) => checkHandler(e)}
          />
          <div className={styles.label_content}>
            위에 명시된 정보를 읽었으며 내 프로필 삭제의 의미를 이해합니다. 내
            프로필 삭제를 진행하고 싶습니다.
          </div>
        </label>
        <br />
        <Button
          color="red"
          text="Delete profile"
          size="large"
          disabled={checked ? false : true}
        />
      </div>
    </div>
  );
}

export default Delete;
