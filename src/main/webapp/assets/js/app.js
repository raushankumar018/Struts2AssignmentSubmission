document.addEventListener('DOMContentLoaded',()=>{
  // Small confetti effect on success pages
  if (document.querySelector('.card.success')) {
    for (let i=0;i<40;i++){
      const s=document.createElement('span');
      s.style.position='fixed';
      s.style.left=Math.random()*100+'%';
      s.style.top='-10px';
      s.style.width=s.style.height='6px';
      s.style.background='hsl('+Math.floor(Math.random()*360)+',90%,60%)';
      s.style.borderRadius='2px';
      s.style.opacity='0.9';
      s.style.transition='transform 3s linear, top 3s linear';
      document.body.appendChild(s);
      setTimeout(()=>{
        s.style.top='110%';
        s.style.transform='rotate('+Math.random()*720+'deg)';
      }, 50+Math.random()*300);
      setTimeout(()=>s.remove(), 3200);
    }
  }
});