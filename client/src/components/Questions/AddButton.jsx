import React from 'react'
import Button from '../UI/Button/Button'
import styles from './AskQuestion.module.css'
function AddButton({text, onClick}) {

  return (
    <div className={styles.AddButton}>
      <Button text={text} onClick={onClick} url='/my'   />
    </div>
  )
}

export default AddButton