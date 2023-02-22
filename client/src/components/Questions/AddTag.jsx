import React, {useState} from 'react'
import Input from '../UI/Input/Input'
import styles from './AskQuestion.module.css'
const GUIDE = 'Add up to 5 tags to describe what your question is about. Start typing to see suggestions.'

function AddTag({tag, tagHandler, enter}) {
  return (
    <div className={styles.AddTag}>
      <h3>Tag</h3>
      <h5>{GUIDE}</h5>
      <Input 
        placeholder='Write Tag'  
        value={tag}
        onChange={tagHandler}
        onPressEnterKey={enter}
        isValid={true} 
      />
    </div>
  )
}


export default AddTag