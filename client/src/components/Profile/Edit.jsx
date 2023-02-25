import { useState, useEffect } from 'react';

import EditIntro from './EditProfile_items/EditIntro';
import EditPic from './EditProfile_items/EditPic';
import Input from '../UI/Input/Input';
import Button from '../UI/Button/Button';

import styles from './Edit.module.css';

// 임의의 데이터
const users = {
  name: `One-Punch Man`,
  profileimage:
    'https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80',
  // '',
  detail: 'Hello World!',
};
//

function Edit() {
  const [userData, setUserData] = useState(null);
  const [name, setName] = useState(users.name);
  const [isOpen, setIsOpen] = useState(false);

  useEffect(() => {
    fetch('http://localhost:4050/profile/2', {
      method: 'GET',
    })
      .then((res) => res.json())
      .then((data) => {
        setUserData(data);
      });
  }, []);
  console.log(userData);
  const openModalHandler = () => {
    setIsOpen(!isOpen);
  };
  const closeModalHandler = () => {
    setIsOpen(false);
  };

  return (
    <div className={styles.Edit_Container}>
      <div className={styles.Edit_Head}>
        <h2 className={styles.Head_title}>Edit your profile</h2>
      </div>
      <>
        <h3 className={styles.Body_title}>Public information</h3>
        <div
          className={styles.Form_container}
          onClick={closeModalHandler}
          role="presentation"
        >
          <h4 className={styles.small_title}>Profile image</h4>
          <EditPic
            openModalHandler={openModalHandler}
            isOpen={isOpen}
            profileimage={users.profileimage}
            userData={userData}
            setUserData={setUserData}
          />
          <h4 className={styles.small_title}>Display name</h4>
          <div className={styles.edit_name}>
            <Input
              size={'large'}
              value={name}
              isValid
              onChange={(e) => setName(e.target.value)}
            />
            <span className={styles.Blank}></span>
          </div>
          <h4 className={styles.small_title}>About me</h4>
          <EditIntro detail={users.detail} />
          <div className={styles.Btn_container}>
            <Button text="Save profile" size="large" />
            <span className={styles.cancel_button}>
              <Button text="Cancel" size="large" color="border" url="/mypage" />
            </span>
            <span className={styles.Blank}></span>
            <Button color="red" text="Delete profile" url="/deleteprofile" />
          </div>
        </div>
      </>
    </div>
  );
}

export default Edit;
