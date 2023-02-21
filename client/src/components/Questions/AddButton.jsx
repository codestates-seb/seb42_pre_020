import React from 'react'
import Button from '../UI/Button/Button'
import styles from '../../pages/AskQuestion.module.css'
function AddButton({text, onClick}) {
  return (
    <div className={styles.AddButton}>
      <Button text={text} onClick={onClick}  />
    </div>
  )
}

export default AddButton