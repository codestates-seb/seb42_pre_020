import React, {useState} from 'react'

import styles from './AskQuestion.module.css'

// const guide = 'Introduce the problem and expand on what you put in the title. Minimum 20 characters.'

function AddBody({body, bodyHandler, title, guide,placeholder}) {
  return (
    <div className={styles.AddBody}>
      <h3>{title}</h3>
      <h5>{guide}</h5>
      <textarea
        className={styles.textarea}
        placeholder={placeholder}
        rows='10' 
        value={body} 
        onChange={bodyHandler} 
      />
    </div>
  )
}




export default AddBody