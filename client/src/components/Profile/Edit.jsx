import { useState } from 'react';
import EditIntro from './MyProfile_items/EditIntro';
import EditPic from './MyProfile_items/EditPic';
import Input from '../UI/Input/Input';
import Button from '../UI/Button/Button';
import styles from './Edit.module.css';

function Edit() {
  const [name, setName] = useState('One-Punch Man');

  return (
    <div className={styles.Edit_Container}>
      <div className={styles.Edit_Head}>
        <h2 className={styles.Head_title}>Edit your profile</h2>
      </div>
      <>
        <h3 className={styles.Body_title}>Public information</h3>
        <div className={styles.Form_container}>
          <h4 className={styles.small_title}>Profile image</h4>
          <EditPic />
          <h4 className={styles.small_title}>Display name</h4>
          <div className={styles.edit_name}>
            <Input
              size={'large'}
              value={name}
              isValid
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <h4 className={styles.small_title}>About me</h4>
          <EditIntro />
          <div className={styles.Btn_container}>
            <Button text="Save profile" size="large" />
            <Button text="Cancel" size="large" color="border" url="" />
            <span className={styles.Blank}></span>
            <Button color="red" text="Delete profile" url="" />
          </div>
        </div>
      </>
    </div>
  );
}

export default Edit;
