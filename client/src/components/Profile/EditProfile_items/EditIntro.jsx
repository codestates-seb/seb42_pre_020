import { useRef } from 'react';
import { Editor } from '@toast-ui/react-editor';
import colorSyntax from '@toast-ui/editor-plugin-color-syntax';
import '@toast-ui/editor/dist/i18n/ko-kr';
import '@toast-ui/editor/dist/toastui-editor.css';
import 'tui-color-picker/dist/tui-color-picker.css';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';

function EditIntro() {
  const editorRef = useRef();

  const onChange = () => {
    const data = editorRef.current.getInstance().getHTML();
    console.log(data);
  };

  return (
    <>
      <Editor
        initialValue="hello world!"
        previewStyle="vertical"
        height="300px"
        initialEditType="wysiwyg"
        useCommandShortcut={false}
        language="ko-KR"
        ref={editorRef}
        onChange={onChange}
        plugins={[colorSyntax]}
      />
    </>
  );
}

export default EditIntro;
