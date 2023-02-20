import React, {useState} from 'react'
import AddTitle from '../components/Questions/AddTitle'
import Side from '../components/Questions/Side'
import AddTag from '../components/Questions/AddTag'
import Button from '../components/UI/Button/Button'
import styles from './AskQuestion.module.css'


const BLUEBOX_CONTENT = `You're ready to ask a programming-related question and this form will help guide you through
the process Looking to ask a non-programming question? See the topics here to find a relevant site.`
const BLUEBOX_LIST = [
  'Summarize your problem in a one-line title.',
  'Describe your problem in more detail.',
  'Describe what you tried and what you expected to happen.'
]
const TitleGuide = 'Be specific and imagine you’re asking a question to another person.'
const TagGuide = 'Add up to 5 tags to describe what your question is about. Start typing to see suggestions.'



function AskQuestion() {
  const [title, setTitle] =useState('')
  const [tag, setTag] =useState([])
  
  const titleHandler = (e) => {
    setTitle(e.target.value)
  }

  const tagHandler = (e) => {
    setTag(e.target.value)
  }

  const submitHandler = () => {
    fetch('https://koreanjson.com/users', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({  }),
    })
      .then((response) => response.json())
      .then((json) => console.log(json))
      .catch((error) => console.log(error));
  }

  
  return (
    <main className={styles.container}>
      <section className={styles.first_section}>
        <h1 className={styles.title}>
          Ask a public question
        </h1>
        <div className={styles.bluebox}>
          <h2 className={styles.bluebox_title}>
            Writing a good question
          </h2>
          <h3 className={styles.bluebox_content}>
            {BLUEBOX_CONTENT}
          </h3>
          <h4>
          Steps
          </h4>
          <ul className={styles.bluebox_list}>
              {
                BLUEBOX_LIST.map((list, idx) => {
                  return <li key={idx}>{list}</li>
                })
              }
          </ul>
      </div>
      </section>
      <section className={styles.second_section}>
        <div className={styles.AddTitle}>
          <AddTitle onSubmit={titleHandler} title={title}/>
        </div>
        <div className={styles.AddTag}>
          <AddTag onSubmit={tagHandler} tag={tag}/>
        </div>
        <div className={styles.Button}>
          <Button text='AskQuestion' onClick={submitHandler}/>
        </div>
      </section>
    </main>
  )
}

export default AskQuestion






  