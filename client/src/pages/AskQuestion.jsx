import React, {useState} from 'react'
import AddTitle from '../components/Questions/AddTitle'
import AddBody from '../components/Questions/AddBody'
import AddTag from '../components/Questions/AddTag'
import AddButton from '../components/Questions/AddButton'
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

  const [title, setTitle] = useState('')
  const [tag, setTag] = useState('')
  const [body, setBody] = useState('') 

  const titleHandler = (e) => {
    setTitle(e.target.value)
  }

  const bodyHandler = (e) => {
    setBody(e.target.value)
  }

  const tagHandler = (e) => {
    setTag(e.target.value)
  }
    


  const clickHandler = (e) => {
    e.preventDefault()
    const inputs = {title, body, tag}
    fetch('url', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({ inputs }),
    })
      .then((response) => response.json())
      .then((json) => console.log(json))
      .catch((error) => console.log(error));
  }

  
  return (
    <main className={styles.container}>
      <section className={styles.section}>
        <h1 className={styles.section_title}>
          Ask a public question
        </h1>
        <div className={styles.section_bluebox}>
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

      <form >
        <AddTitle titleHandler={titleHandler} title={title}/>
        <AddBody body={body} bodyHandler={bodyHandler}/>
        <AddTag tagHandler={tagHandler} tag={tag} />
        <AddButton text='Ask Question' onClick={clickHandler} />
      </form>
    </main>
  )
}








export default AskQuestion






  