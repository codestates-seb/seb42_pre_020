import { useState } from 'react';
import Button from '../components/UI/Button/Button';
import Modal from '../components/UI/Modal/Modal';

function ModalTest() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleModalHandler = () => {
    setIsOpen((prev) => !prev);
  };

  const onClickHandler = () => {
    console.log('모달 버튼 클릭');
  };
  return (
    <div>
      <Button text="Modal Open" onClick={toggleModalHandler} />
      {isOpen && (
        <Modal
          title="Delete this answered question?"
          buttonText="Delete Question"
          onClose={toggleModalHandler}
          onClick={onClickHandler}
        >
          <div>
            We do not recommend deleting questions with answers because doing so
            deprives future readers of this knowledge. See
            <a href="/">
              &quot;I&apos;v thought better of my question; can I delete
              it?&quot;
            </a>
            fro alternatives to deletion. Repeated deletion of answered
            questions can result in your account being{' '}
            <a href="/">blocked from asking.</a> Are you sure you wish to
            delete?
          </div>
        </Modal>
      )}
    </div>
  );
}

export default ModalTest;
