import React, { useState } from 'react'
import Input from '../UI/Input/Input'
import styles from '../../pages/AskQuestion.module.css'

const GUIDE = 'Be specific and imagine you’re asking a question to another person.'

//여기다 fetch함수로 서버에 데이터 보내는 거 입력하는 건가??
//그리고 Input에 props로 onSubmit내려주는 건가??
const SubmitHandler =() => {}

function AddTitle({titleHandler, title}) {


  return (
      <div className={styles.AddTitle}>
        <h3>Title</h3>
        <h5>{GUIDE}</h5>
        <Input placeholder='write title' value={title} onChange={titleHandler}  />
      </div>
  )
}

export default AddTitle

